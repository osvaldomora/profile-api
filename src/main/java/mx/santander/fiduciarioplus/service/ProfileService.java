package mx.santander.fiduciarioplus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.santander.fiduciarioplus.dto.getprofile.DataDto;
import mx.santander.fiduciarioplus.dto.getprofile.DataProfileResDto;
import mx.santander.fiduciarioplus.dto.getprofile.ProfileDto;
import mx.santander.fiduciarioplus.lib.exception.catalog.GeneralCatalog;
import mx.santander.fiduciarioplus.lib.exception.catalog.PersistenDataCatalog;
import mx.santander.fiduciarioplus.lib.exception.model.GeneralException;
import mx.santander.fiduciarioplus.lib.exception.model.PersistenDataException;
import mx.santander.fiduciarioplus.model.profile.Access;
import mx.santander.fiduciarioplus.model.profile.Business;
import mx.santander.fiduciarioplus.model.profile.Profile;
import mx.santander.fiduciarioplus.model.profile.SubBusiness;
import mx.santander.fiduciarioplus.repository.IAccessRepository;
import mx.santander.fiduciarioplus.repository.IBusinessRepository;
import mx.santander.fiduciarioplus.repository.IProfileRepository;
import mx.santander.fiduciarioplus.repository.ISubBusinessRepository;

@Service
public class ProfileService implements IProfileService {

	@Autowired
	IBusinessRepository iBusinessRepository;
	@Autowired
	IProfileRepository iProfileRepository;
	@Autowired
	ISubBusinessRepository iSubBusinessRepository;
	@Autowired
	IAccessRepository iAccessRepository;

	private List<Profile> profileDb;//emulacion de DB en lista
	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public DataProfileResDto convert(String buc) {
		exist(buc);
		Profile profile = getProfile(buc);


//		profile.getNegocios().stream().filter
//		(negocio->!negocio.getStatus().equals("VIGENTE") && !negocio.getStatus().equals("PROCESO CANCELACION"))
//		.map(x->{
//			x.setSubnegocios(new ArrayList<>());
//			return  x;
//		});
		ProfileDto pDto = modelMapper.map(profile, ProfileDto.class);
		DataDto dataDto = new DataDto(pDto);
		DataProfileResDto dpRDto = new DataProfileResDto(dataDto);
		return dpRDto;
	}

	@Override
	public Profile getProfile(String buc) {
		List<Profile> profileExist = profileDb.stream().filter(profile -> profile.getBuc().equals(buc))
				.collect(Collectors.toList());
		System.out.println("IMPRIMIENDO PERFIL" + profileExist.size());
	     profileExist.stream().forEach(x->System.out.println(x));
		return profileExist.get(0);
	}

	@Override
	public boolean exist(String buc) {

		Optional<Profile> op = iProfileRepository.findByBuc(buc);
		System.out.println("optional" + op.isEmpty());
		// valida si el perfil existe
		if (op.isEmpty())
			op.orElseThrow(()-> new GeneralException(GeneralCatalog.GRAL003));

		return op.isPresent();
	}

	@Override
	public void saveData() {

		Profile p1 = Profile.builder().id(23L).buc("123456789123").type("FIDEICOMITENTE").status("ACTIVO").build();
		iProfileRepository.save(p1);
		Profile p2 = Profile.builder().id(24L).buc("123456789124").type("FIDEICOMISARIO").status("ACTIVO").build();
		iProfileRepository.save(p2);
		
		Profile p3 = Profile.builder().id(25L).buc("123456789125").type("COMITE_TECNICO").status("BAJA").negocios(new ArrayList<Business>()).build();
		iProfileRepository.save(p3);

		iProfileRepository.findAll().stream().forEach(x -> System.out.println(x));
		// negocios del 23
		Business bus1 = Business.builder().id(30L).typeBusiness("S").bussiness("12345678").build();
		iBusinessRepository.save(bus1);
		Business bus2 = Business.builder().id(31L).typeBusiness("S").bussiness("12345679").build();
		iBusinessRepository.save(bus2);

		// subnegocios del negocio 1 perfil1
		SubBusiness subBus1_1 = SubBusiness.builder().id(40L).idSubBusiness("0040").build();
		iSubBusinessRepository.save(subBus1_1);
		SubBusiness subBus1_2 = SubBusiness.builder().id(41L).idSubBusiness("0041").build();
		iSubBusinessRepository.save(subBus1_2);
		iSubBusinessRepository.findAll().stream().forEach(x -> System.out.println(x));

		// subnegocio del negocio2 perfil1
		SubBusiness subBus2_1 = SubBusiness.builder().id(43L).idSubBusiness("0043").build();
		iSubBusinessRepository.save(subBus2_1);

		// access subnegocio1 del negocio1
		List<Access> access1 = Arrays.asList(
				Access.builder().description("ALTA_INSTRUCCIONES").idAccess("1231").build(),
				Access.builder().description("CONSULTAR_SUCURSALES").idAccess("1232").build(),
				Access.builder().description("CONSULTAR_BANCOS").idAccess("1233").build(),
				Access.builder().description("ESTADO_DE_CUENTA").idAccess("1234").build(),
				Access.builder().description("CONSULTAR_NSTRUCCIONES").idAccess("1235").build());
		// access subnegocio2 del negocio1
		List<Access> access2 = Arrays.asList(Access.builder().description("ALTA_INSTRUCCIONES").idAccess("1231").build(),
				Access.builder().description("CONSULTAR_SUCURSALES").idAccess("1232").build(),
				Access.builder().description("CONSULTAR_BANCOS").idAccess("1233").build(),
//				Access.builder().idDescription("ESTADO_DE_CUENTA").idAccess(false).build(),
				Access.builder().description("CONSULTAR_NSTRUCCIONES").idAccess("1235").build());
		// access subnegocio1 del negocio2
		List<Access> access3 = Arrays.asList(
//				Access.builder().idDescription("ALTA_INSTRUCCIONES").idAccess(false).build(),
				Access.builder().description("CONSULTAR_SUCURSALES").idAccess("1232").build(),
//				Access.builder().idDescription("CONSULTAR_BANCOS").idAccess(false).build(),
//				Access.builder().idDescription("ESTADO_DE_CUENTA").idAccess(false).build(),
				Access.builder().description("CONSULTAR_NSTRUCCIONES").idAccess("1235").build());

		subBus1_1.setAccess(access1);
		subBus1_2.setAccess(access2);
		List<SubBusiness> sub11 = Arrays.asList(subBus1_1, subBus1_2);
		bus1.setSubnegocios(sub11);// 2 subnegocios del negocio1 perfil1

		subBus2_1.setAccess(access3);
		List<SubBusiness> sub12 = Arrays.asList(subBus2_1);
		bus2.setSubnegocios(sub12);// 1 subnegocio del negocio 2 perfil1

		List<Business> b1y2 = Arrays.asList(bus1, bus2);// 2 negocios que se le asignaran al perfil 1
		p1.setNegocios(b1y2);
		System.out.println(p1);

		// NEGOCIO del 24
		Business bus3 = Business.builder().id(32L).typeBusiness("I").bussiness("12345679").build();
		iBusinessRepository.save(bus3);
		iBusinessRepository.findAll().stream().forEach(x -> System.out.println(x));

		SubBusiness subBus1N2 = SubBusiness.builder().id(42L).idSubBusiness("0042").build();
		iSubBusinessRepository.save(subBus1N2);

		// access subnegocio1 del negocio2
		List<Access> accesubBus1N2 = Arrays.asList(
				Access.builder().description("ALTA_INSTRUCCIONES").idAccess("1231").build(),
				Access.builder().description("CONSULTAR_SUCURSALES").idAccess("1232").build(),
				Access.builder().description("CONSULTAR_BANCOS").idAccess("1233").build(),
				Access.builder().description("ESTADO_DE_CUENTA").idAccess("1234").build(),
				Access.builder().description("CONSULTAR_NSTRUCCIONES").idAccess("1235").build());

		subBus1N2.setAccess(accesubBus1N2);
		List<SubBusiness> laccesubBus1N2 = Arrays.asList(subBus1N2);
		bus3.setSubnegocios(laccesubBus1N2);// 1 subnegocio del negocio1

		List<Business> b3p2 = Arrays.asList(bus3);// 1 negocio que se le asignaran al perfil 2
		p2.setNegocios(b3p2);

		profileDb = Arrays.asList(p1, p2,p3);//se agrega perfil a la lista si se desea agregar un elemento nuevo

	}

}
