package mx.santander.fiduciarioplus.dto.getprofile;



import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.santander.fiduciarioplus.dto.enums.Status;
import mx.santander.fiduciarioplus.dto.enums.TypeUser;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDto implements Serializable
{

    private String buc;
    private TypeUser type ;
	private Status status;
    @JsonProperty("business")
    private List<BusinessDto> negocios = null;
    private final static long serialVersionUID = 3142992583074199499L;

}
