package mx.santander.fiduciarioplus.model.profile;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "SUBUSINESS")
public class SubBusiness implements Serializable {
	

	private static final long serialVersionUID = 5286306995658242296L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "ID_SUB_BUSINESS")
	private String idSubBusiness;
	
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="ID_BUSINESS")
//	private Business business;
	
//	@OneToMany(mappedBy = "subBusiness", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonInclude()
	@Transient
	private List<Access> access;
	
	

	


 

}
