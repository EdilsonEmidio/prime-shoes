package br.com.primeshoes.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import br.com.primeshoes.api.entities.Cart;
import br.com.primeshoes.api.entities.CartItem;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    
    @NativeQuery("SELECT ci.* FROM cart_items ci WHERE ci.id = :idCI")
    public Optional<CartItem> findCartItem(long idCI);
    
    @NativeQuery("DELETE FROM cart_items ci WHERE ci.id = :idCI")
    public void deleteCartItem(long idCI);
    
    @NativeQuery("SELECT * FROM cart_items ci WHERE ci.cart_id = :idC")
    public List<CartItem> listAllCartItem(long idC);
    
    @NativeQuery("INSERT INTO cart_items (product_variation_id,"
    		+ "cart_id, quantity, subtotal) VALUES"
    		+ " (cartItem.getProductVariation, cartItem.getCart, cartItem.getQuantity, cartItem.getSubtotal)")
    public void saveCartItem(CartItem cartItem);
    
}
