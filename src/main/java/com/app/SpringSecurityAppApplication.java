package com.app;

import com.app.Persistem.entity.PermissionEntity;
import com.app.Persistem.entity.RoleEntity;
import com.app.Persistem.entity.RoleEnum;
import com.app.Persistem.entity.UserEntity;
import com.app.Persistem.entity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

		@Bean
		CommandLineRunner init(UserRepository userRepository){
		return args -> {

			//crear permosos
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();
			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();
			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();
			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();
			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("refactor")
					.build();


			// creacion de roles
			RoleEntity roleAdmin = RoleEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission,deletePermission))
					.build();
			RoleEntity roleUser = RoleEntity.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(createPermission, readPermission))
					.build();
			RoleEntity roleInvited = RoleEntity.builder()
					.roleEnum(RoleEnum.INVITED)
					.permissionList(Set.of(readPermission))
					.build();
			RoleEntity roleDeveloper= RoleEntity.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission,deletePermission,refactorPermission))
					.build();

			//creacion de usuarios
			UserEntity userDavid = UserEntity.builder()
					.username("David")
					.password("$2a$10$C0gyHtzzB7rAxwpIcUahJ.PwChDGkZtgz/Yy8MlvP4sjSEk/gUVv6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UserEntity userCris = UserEntity.builder()
					.username("Cris")
					.password("$2a$10$C0gyHtzzB7rAxwpIcUahJ.PwChDGkZtgz/Yy8MlvP4sjSEk/gUVv6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UserEntity userChicaiza = UserEntity.builder()
					.username("Chicaiza")
					.password("$2a$10$C0gyHtzzB7rAxwpIcUahJ.PwChDGkZtgz/Yy8MlvP4sjSEk/gUVv6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UserEntity userConteron = UserEntity.builder()
					.username("Conteron")
					.password("$2a$10$C0gyHtzzB7rAxwpIcUahJ.PwChDGkZtgz/Yy8MlvP4sjSEk/gUVv6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userDavid, userConteron,userCris, userChicaiza));
		};
	}

}















