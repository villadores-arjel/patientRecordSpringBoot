package com.jelproject.patientrecord.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jelproject.patientrecord.model.Patient;
import com.jelproject.patientrecord.service.PatientService;

@Controller
public class PatientMVCController {
	
	private PatientService patientService;
	
	@Autowired
	public PatientMVCController(PatientService patientService)
	{
		this.patientService = patientService;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String showHome(Model model)
	{
		model.addAttribute("patient", new Patient());
		return "home";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("patient") @Valid  Patient patient, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return "home";
		}
		Patient response = patientService.add(patient);
		return "redirect:/"+response.getId();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String viewPatientByID(@PathVariable("id") String id, Model model)
	{
		List<Patient> patient = patientService.findByID(id);
		model.addAttribute("patientList", patient);
		return "viewList";
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET)
	public String viewAllPatients(Model model)
	{
		List<Patient> patients = patientService.findAll();
		model.addAttribute("patientList", patients);
		return "viewList";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String viewPatientByName(@RequestParam("name") String name, Model model)
	{
		List<Patient> patients = patientService.findByName(name);
		model.addAttribute("patientList", patients);
		return "viewList";
	}

}
