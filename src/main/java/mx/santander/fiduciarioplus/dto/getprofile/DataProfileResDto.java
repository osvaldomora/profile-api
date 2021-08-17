package mx.santander.fiduciarioplus.dto.getprofile;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataProfileResDto implements Serializable
{

    private DataDto data;
    private final static long serialVersionUID = -5326901754762982852L;

}
