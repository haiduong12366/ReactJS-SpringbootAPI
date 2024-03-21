package ReactJSSpringBoot.Entity;
import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*; 
import lombok.*;

@Entity

@Data

@AllArgsConstructor

@NoArgsConstructor
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long categoryId;
	private String categoryName;
	private String icon;
	@JsonIgnore
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL )
	private Set<Product> products;

}
