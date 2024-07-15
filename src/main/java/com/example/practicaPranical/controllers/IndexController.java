package com.example.practicaPranical.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.practicaPranical.Models.Persona;
import com.example.practicaPranical.Models.User;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/user")
public class IndexController {
	
	@GetMapping("/consulta")
	public String getUser(Model m) {
		
		List<String>userList_= new ArrayList<>(Arrays.asList("Erika", "Andrés","Pedro","Victor"));
														
		
		List<User>userList = new ArrayList<>(Arrays.asList(new User(1,"Lenin","Manrique","v","10868349"),
													       new User(2,"Zerika", "Diaz", "v", "15581951"),
														   new User(3,"Andrés", "Díaz","v","5412587"),
														   new User(4,"Aurora","Pérez","V","5418737")));
		
		int[] numeros= new int[] {85,21,0,-1,4};
		
		//Ordenar una lista de enteros de forma ascendente.
		
		//Arrays.sort(numeros);
		
		//Ordenar de forma descendente:
		
		Integer[]ArrayInteger= Arrays.stream(numeros).boxed().toArray(Integer[]::new);
		
		Arrays.sort(ArrayInteger, Collections.reverseOrder());
		
		/*Integer[]ArrayInteger= Arrays.stream(numeros).boxed().toArray(Integer[]::new);
		
		Arrays.sort(ArrayInteger,(x,y)->x.compareTo(y));*/
		
		System.out.println("Números:");
		
		for(int num: ArrayInteger) {
			
			System.out.println(num);
		}
		
		
		//Cuando es una lista de tipo 'String', se puede hacer el ordenamiento así
		//de forma descendente:	
		
		//Collections.sort(userList_, Collections.reverseOrder());
		
		//userList_.sort(Collections.reverseOrder());
		
		//De forma ascendente:
		
		//Collections.sort(userList_, (x,y)->x.compareTo(y));
		
		//userList_.sort((x,y)->x.compareTo(y));
		
		
		//Cuando es una lista de Objetos y se desea ordenar de forma ascendente, haciendo
		//uso del Api Stream()
		
		/*List<User> personasOrdenadas = userList.stream()
		        .sorted((p1, p2) -> p1.getNombre().compareTo(p2.getNombre())) // ordenar por nombre de forma ascendente
		        .collect(Collectors.toList()));*/
		
		//Haciendo uso de la clase collections
		
		//Collections.sort(userList,(x,y)->x.getNombre().compareTo(y.getNombre()));
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		//Recorrer array con java lambda ForEach, manejandolo con un indice
		
		
		/*System.out.println("++++++++++++++++++++ Probando IntStream +++++++++++++++++++++++");
		IntStream.range(0,numeros.length).forEach(i->System.out.println(numeros[i]));*/
		
				
		
		/*System.out.println("++++++++++++ Recorrer una lista de tipo String con java Lambda forEach e indice +++++");
		
		List<String>lista = new ArrayList<>(Arrays.asList("Andrés","Juan", "Mario", "Pablo"));
        
		IntStream.range(0, lista.size()).forEach(index->System.out.println(lista.get(index)));*/
		
		
		System.out.println("++++++++++++ Recorrer una lista de tipo Objeto con forEach e indice +++++");
       
		List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Juan"));
        personas.add(new Persona("Ana"));
        personas.add(new Persona("Pedro"));
        
        Collections.sort(personas, (x,y)->x.getNombre().compareTo(y.getNombre()));
        
        /*Collections.sort(personas, new Comparator<Persona>() {

			@Override
			public int compare(Persona o1, Persona o2) {
				// TODO Auto-generated method stub
				return o1.getNombre().compareTo(o2.getNombre());
			}
        	
        }
        		);*/
        
        IntStream.range(0, personas.size()).forEach(index->System.out.println(personas.get(index).getNombre()));
		
		//+++++++++++++++++++++++++++++++ JAVA 7 +++++++++++++++++++++++++++++++++++++++
		
		Collections.sort(userList, new Comparator<User>() {
		    @Override
		    public int compare(User x, User y) {
		        return y.getUserName().compareTo(x.getUserName());
		        
		       
		    }
		});
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		
		for(User usuario: userList) {
			
			System.out.println(usuario.getUserName());
			
		}
		
		
		
		/*userList.sort((x,y)->x.getUserName().compareTo(y.getUserName()));	
	
		//Recorrer la lista haciendo uso de un forEach.
		userList.forEach(persona->System.out.println(persona.getUserName()+" "+persona.getUserLastName()));*/
		
		
		m.addAttribute("titulo", "Bienvenido a la práctica con Thymeleaft");
		m.addAttribute("listado", userList);		

		
		return "Index";
		
	}
	
	
	@GetMapping("/form")
	public String form(User user,Model model) {
		
		model.addAttribute("usuario",user);
		
		return "form";
	}
	
	/*@PostMapping("/form")
	public String procesar(Model model, 
			@RequestParam String userName,
			@RequestParam String userLastName,
			@RequestParam String userTipoDoc,
			@RequestParam String userNumDoc) {
		
		model.addAttribute("userName", userName);
		model.addAttribute("userLastName", userLastName);
		model.addAttribute("userTipoDoc", userTipoDoc);
		model.addAttribute("userNumDoc",userNumDoc);
		
		return "resultado";
	}*/
	
	
	/*@PostMapping("/form")
	public String procesar(Model model,
			@RequestParam String userName,
			@RequestParam String userLastName,
			@RequestParam String userTipoDoc,
			@RequestParam String userNumDoc) {
		
		User user=new User();
		
		user.setUserName(userName);
		user.setUserLastName(userLastName);
		user.setUserTipoDoc(userTipoDoc);
		user.setUserNumDoc(userNumDoc);
		
		model.addAttribute("titulo", "Formulario");
		model.addAttribute("usuario",user);
		
		return "resultado_";
	}*/
	
	@PostMapping("/form")
	public String procesar(@Valid User user, BindingResult result, Model model) {		
		
		
		model.addAttribute("titulo", "Formulario");	
		
		
		
		if(result.hasErrors()) {
			
			Map<String,String> errores= new HashMap<>();
			
			/*List<String>errors=result.getFieldErrors().stream().map(error->"El campo: "
			.concat(error.getField().concat(" ").concat(error.getDefaultMessage()))).toList();
			
			errors.forEach(error->map.put("error", error));*/
			
			result.getFieldErrors().forEach(error->{
			
			errores.put(error.getField(), "El campo: ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()));
					
							
			});
			
			System.out.println("Mapa: "+errores);
			
			model.addAttribute("error",errores);
			model.addAttribute("usuario",user);
			
			return "form";
		}
		
		model.addAttribute("usuario",user);
		
		System.out.println("Pasa por aqui");
		
		return "resultado_";
	}
	

}
