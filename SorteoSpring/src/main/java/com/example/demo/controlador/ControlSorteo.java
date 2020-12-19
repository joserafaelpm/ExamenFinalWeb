package com.example.demo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entidades.Sorteo;
import com.example.demo.modeloDao.ISorteo;

@Controller
public class ControlSorteo {
	@Autowired
	ISorteo sDAO;
	
	@GetMapping({ "/", "/index2" })
	//@RequestMapping
		public String List(Model model) {
			model.addAttribute("listaSorteos", sDAO.findAll());
			return "index2";
		}
	//@GetMapping({"/", "/eliminar/{id}"})
		@RequestMapping(value = "/eliminar/{id}")
		public String eliminar(@PathVariable(value = "id") Integer id, Model model) {
			sDAO.deleteById(id);
			return "redirect:/index2";
		}
		//@GetMapping({"/", "/crear/"})
		@RequestMapping(value = "/crear/")
		public String crear(Model model) {
			Sorteo sorteo= new Sorteo();
			model.addAttribute("sorteo", sorteo);
			return "formularioSorteo";
		}
		//@GetMapping({"/", "/form"})
		@RequestMapping(value = "/form", method = RequestMethod.POST)
		public String guardar(@Validated Sorteo sorteo, Model model) {
			sDAO.save(sorteo);
			return "redirect:index2";
		}
		//@GetMapping({"/", "/form/{id}"})
		@RequestMapping(value = "/form/{id}")
		public String editar(@PathVariable(value = "id") Integer id, Model model) {
			Sorteo sorteo = sDAO.findById(id).orElse(null);
			model.addAttribute("Sorteo", sorteo);
			return "formularioSorteo";

		}
}
