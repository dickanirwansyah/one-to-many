package com.springboot.onetomany.onetomany;

import com.springboot.onetomany.onetomany.entity.Cart;
import com.springboot.onetomany.onetomany.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@SpringBootApplication
public class OnetomanyApplication {


	public static void main(String[] args) {
		SpringApplication.run(OnetomanyApplication.class, args);


	}
}


@Transactional
@Service
@Repository
@Component
class CommandLineRunnerTest implements CommandLineRunner{

	private final RepositoryCart repositoryCart;

	private final RepositoryItems repositoryItems;

	@Autowired
	public CommandLineRunnerTest(RepositoryCart repositoryCart,
								 RepositoryItems repositoryItems){
		this.repositoryCart=repositoryCart;
		this.repositoryItems=repositoryItems;
	}

	@Override
	public void run(String... strings) throws Exception {
		Cart cart = new Cart();
		cart.setTanggal(new Date());
		cart.setCustomer("Muhammad Dicka Nirwansyah");

		Items items1 = new Items(cart, "ipod shuffle", 1, 1000 );
		Items items2 = new Items(cart, "headset ipod original", 1, 15000);
		Items items3 = new Items(cart, "Tas", 1, 15000);
		Items items4 = new Items(cart, "Sepatu", 1, 15000);
		Items items5 = new Items(cart, "Gelang", 1, 15000);
		Items items6 = new Items(cart, "Topi", 1, 15000);

		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(items1);
		itemsSet.add(items2);
		itemsSet.add(items3);
		itemsSet.add(items4);
		itemsSet.add(items5);
		itemsSet.add(items6);

		repositoryCart.save(cart);
		repositoryItems.save(itemsSet);
	}
}


interface RepositoryCart extends JpaRepository<Cart, Long>{

}

interface RepositoryItems extends JpaRepository<Items, Long>{

}
