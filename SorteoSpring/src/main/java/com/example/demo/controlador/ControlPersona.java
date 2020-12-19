package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entidades.Persona;
import com.example.demo.modeloDao.IPersona;
import com.example.demo.modeloDao.ISorteo;

@Controller
public class ControlPersona {
	@Autowired
	IPersona pDAO;
	@Autowired
	ISorteo sDAO;
	
	@GetMapping({ "/", "/index" })
	//@RequestMapping
		public String List(Model model) {
			model.addAttribute("listaPersonas", pDAO.findAll());
			return "index";
		}

		@RequestMapping(value = "/eliminar/{id}")
		public String eliminar(@PathVariable(value = "id") Integer id, Model model) {
			// Optional<Heroe> heroe = hDAO.findById(id);
			pDAO.deleteById(id);
			return "redirect:/index";
		}

		@RequestMapping(value = "/crear/")
		public String crear(Model model) {
			Persona persona= new Persona();
			model.addAttribute("persona", persona);
			model.addAttribute("listaSorteo", sDAO.findAll());
			return "formularioPersona";
		}

		@RequestMapping(value = "/form", method = RequestMethod.POST)
		public String guardar(@Validated Persona persona, Model model) {
			pDAO.save(persona);
			return "redirect:index";
		}

		@RequestMapping(value = "/form/{id}")
		public String editar(@PathVariable(value = "id") Integer id, Model model) {
			Persona persona = pDAO.findById(id).orElse(null);
			model.addAttribute("Persona", persona);
			return "formularioPersona";

		}
}
