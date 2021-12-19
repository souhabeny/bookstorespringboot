package com.sip.ams.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Categorie;

import com.sip.ams.repositories.CategorieRepository;

@Controller
@RequestMapping("/categorie/")
public class ControllerCategorie {
	private final CategorieRepository categorieRepository;
	@Autowired
	public ControllerCategorie(CategorieRepository categorieRepository) {
		this.categorieRepository=categorieRepository;
	}
	/*@GetMapping("add")
	public String listCategories(Model model) {

	model.addAttribute("categories",categorieRepository.findAll());
	return "categorie/addCategorie";
	}*/
	@GetMapping("list")
	public String showAddcategorieForm(Model model) {
	Categorie categorie = new Categorie();
	model.addAttribute("categories",categorieRepository.findAll());
	model.addAttribute("categorie", categorie);
	return "categorie/addCategorie";
	}
	@PostMapping("add")
	public String addCategorie(@Valid Categorie categorie,BindingResult result, Model model) {
	if (result.hasErrors()) {
	return "categorie/addCategorie";
	}
	categorieRepository.save(categorie);
	return "redirect:list";
	}
	@GetMapping("delete/{id}")
	public String deleteCategorie(@PathVariable("id") long id, Model model) {

	Categorie categorie = categorieRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid  Id:" + id));
	System.out.println("categorie supprimé...");
	categorieRepository.delete(categorie);
	return "redirect:../list";
	}
	@ResponseBody
	@GetMapping("edit/{id}")
	public Categorie showFormToUpdate(@PathVariable ("id") long id, Model model)
	{
			Categorie categorie = categorieRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id:" + id));
			model.addAttribute("categorie", categorie);
			System.out.println(categorie.getId());
			//return "categorie/addCategorie";
			return categorie;
	}
	@PostMapping("update")
	public String update(@Valid Categorie categorie, BindingResult result, Model model) {

		categorieRepository.save(categorie);
		return "redirect:list";
	}

}
