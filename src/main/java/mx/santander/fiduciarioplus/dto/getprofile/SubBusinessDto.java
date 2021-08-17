package mx.santander.fiduciarioplus.dto.getprofile;


import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubBusinessDto implements Serializable
{
    @JsonIgnore
    public Long id;
    @JsonProperty("id")
    private String idSubBusiness;
    @JsonProperty("permissions")
    public List<AccessDto> access = null;
    private final static long serialVersionUID = 3927907583846773427L;

}
