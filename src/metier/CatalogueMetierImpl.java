package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements ICatalogue{

	@Override
	public void addProduit(Produit p) {
	Connection conn = SingletonConnection.getConnection();
	try {
		PreparedStatement st = conn.prepareStatement("insert into PRODUITS(ref_prod, destination, prix,quantite) VALUES (?,?,?,?)");
		st.setString(1, p.getReference());
		st.setString(2, p.getDestination());
		st.setDouble(3, p.getPrix());
		st.setInt(4, p.getQuantite());
		
		st.executeUpdate();
		st.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public List<Produit> listProduits() {
		List<Produit> prods = new ArrayList<Produit>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement("select * from PRODUITS");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				Produit p = new Produit();
				p.setReference(rs.getString("ref_prod"));
				p.setDestination(rs.getString("destination"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				prods.add(p);
			}

			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> prods = new ArrayList<Produit>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement("select * from PRODUITS where destination like ?");
			st.setString(1, "%"+mc+"%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				
				Produit p = new Produit();
				p.setReference(rs.getString("ref_prod"));
				p.setDestination(rs.getString("destination"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				prods.add(p);
			}

			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prods;
	}

	@Override
	public Produit getProduit(String ref) {
	
		Produit p= null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement("select * from PRODUITS where ref_prod=?");
			st.setString(1, ref);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				p= new Produit();
				p.setReference(rs.getString("ref_prod"));
				p.setDestination(rs.getString("destination"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
			}

			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(p==null) throw new RuntimeException("Produit" + ref + "introuvable");
		return p;
	}

	@Override
	public void updateProduit(Produit p) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement
					("update PRODUITS set destination=?, prix=?,quantite=? where ref_prod=?");
			st.setString(4, p.getReference());
			st.setString(1, p.getDestination());
			st.setDouble(2, p.getPrix());
			st.setInt(3, p.getQuantite());
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduit(String ref) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement
					("delete from PRODUITS where ref_prod=?");
			st.setString(1, ref);			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
