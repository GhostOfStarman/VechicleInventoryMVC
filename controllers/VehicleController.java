package com.vehicleinventory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vehicleinventory.entity.CustomerAccount;
import com.vehicleinventory.entity.Vehicle;
import com.vehicleinventory.service.VehicleService;

@Controller
@RequestMapping("/inventory")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	// reading all objects
	// mapping for listing all vehicles of directory
	@GetMapping("/listAll")
	public String listVehicles(Model model) {
		List<Vehicle> inventory = vehicleService.getVehicles();
		model.addAttribute("Vehicles", inventory);
		
		return "all-vehicles";
	}
	
	// creating entry
	// add vehicle button
	@GetMapping("/addVehicle")
	public String showAddVehicleForm(Model model) {
		Vehicle car = new Vehicle();
		model.addAttribute("Vehicle", car);
		return "vehicle-add-form";
	}
	
	
	// --------- Form data submission ----------------------- >
	// submitting form information for adding vehicle
	@PostMapping("/addVehicleSave")
	public String addVehicleSave(@Valid @ModelAttribute("Vehicle") Vehicle car, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "vehicle-add-form";
		}
		vehicleService.saveVehicle(car);
		return "redirect:/inventory/listAll";
	}
	

	// submitting form information for updating vehicle
	@PostMapping("/updateVehicleSave")
	public String updateVehicleSave(@Valid @ModelAttribute("Vehicle") Vehicle car, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "vehicle-update-form";
		}
		vehicleService.saveVehicle(car);
		return "redirect:/inventory/listAll";
	}
	
	// ------------Links in main table ------------------------ >
	// mapping the view full details link in table
		@GetMapping("/showFullDetails")
		public String showVehicleDetails(@RequestParam("vehicleIdNumber") String vin, Model model) {
			Vehicle car = vehicleService.getVehicle(vin);
			model.addAttribute("car", car);
			return "full-details";
		}

	// mapping the update form link in table
	@GetMapping("/showUpdateForm")
	public String showFormForUpdate(@RequestParam("vehicleIdNumber") String vin, Model model) {
		Vehicle car = vehicleService.getVehicle(vin);
		model.addAttribute("Vehicle", car);
		return "vehicle-update-form";
	}
	
	// mapping delete link in table
	@GetMapping("/delete")
	public String deleteVehicle(@RequestParam("vehicleIdNumber") String vin, Model model) {
		vehicleService.deleteVehicle(vin);
		return "redirect:/inventory/listAll";
	}

	// ----------------------------- Customer Accounts -------------------------------------------------- >
	@GetMapping("/listAccounts")
	public String listCustomerAccounts(Model model) {
		List<CustomerAccount> users = vehicleService.getCustomerAccounts();
		model.addAttribute("Customers", users);
		
		return "all-customers";
	}
	
	@GetMapping("/showCustomerUpdateForm")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		CustomerAccount account = vehicleService.getCustomerAccount(id);
		model.addAttribute("CustomerAccount", account);
		return "customer-update-form";
	}
	
	@GetMapping("/deleteAccount")
	public String deleteVehicle(@RequestParam("customerId") int id, Model model) {
		// vehicleService.deleteCustomerAccount(id);
		return "redirect:/inventory/listAccounts";
	}
}


