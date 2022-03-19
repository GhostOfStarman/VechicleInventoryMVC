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
import com.vehicleinventory.entity.FinanceRecord;
import com.vehicleinventory.entity.Vehicle;
import com.vehicleinventory.service.VehicleService;

@Controller
@RequestMapping("/inventory")
public class VehicleController {
	
	// injection of the service gives access to multiple tables in the Schema
	@Autowired
	VehicleService vehicleService;
	
	// mapping for listing all vehicles of directory
	@GetMapping("/listAll")
	public String listVehicles(Model model) {
		List<Vehicle> inventory = vehicleService.getVehicles();
		model.addAttribute("Vehicles", inventory);
		
		return "all-vehicles";
	}
	
	// add vehicle button
	@GetMapping("/addVehicle")
	public String showAddVehicleForm(Model model) {
		Vehicle car = new Vehicle();
		model.addAttribute("Vehicle", car);
		return "vehicle-add-form";
	}
	
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
	
	// ------ action links within main table ------ >
	// mapping the view full details link in table
	@GetMapping("/showFullDetails")
	public String showVehicleDetails(@RequestParam("vehicleIdNumber") String vin, Model model) {
		Vehicle car = vehicleService.getVehicle(vin);
		model.addAttribute("car", car);
		return "full-vehicle-details";
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

	// ------------------- CustomerAccount methods ---------------------------------- >
	
	// listing all customer accounts
	@GetMapping("/listAccounts")
	public String listCustomerAccounts(Model model) {
		List<CustomerAccount> users = vehicleService.getCustomerAccounts();
		model.addAttribute("CustomerAccounts", users);
		
		return "all-customers";
	}
	
	// deletes customer account
	@GetMapping("/deleteCustomerAccount")
	public String deleteCustomerAccount(@RequestParam("customerId") int custId, Model model) {
		vehicleService.deleteCustomerAccount(custId);
		return "redirect:/inventory/listAccounts";
	}
	
	
	// shows form for adding new customer 
	@GetMapping("/addCustomerAccount")
	public String showAddCustomerForm(Model model) {
		CustomerAccount account = new CustomerAccount();
		model.addAttribute("CustomerAccount", account);
		return "customer-add-form";
	}
	
	// new customer data submission
	@PostMapping("/addCustomerAccountSave")
	public String addCustomerAccountSave(@Valid @ModelAttribute("CustomerAccount") CustomerAccount account, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer-add-form";
		}
		vehicleService.saveCustomerAccount(account);
		return "redirect:/inventory/listAccounts";
	}
	
	// displays update form for customer account
	@GetMapping("/showCustomerUpdateForm")
	public String showCustomerFormForUpdate(@RequestParam("customerId") int custId, Model model) {
		CustomerAccount account = vehicleService.getCustomerAccount(custId);
		model.addAttribute("CustomerAccount", account);
		return "customer-update-form";
	}
	
	// form for updating customer account/data submission
	@PostMapping("/updateCustomerAccountSave")
	public String updateCustomerAccountSave(@Valid @ModelAttribute("CustomerAccount") CustomerAccount account, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer-update-form";
		}
		vehicleService.saveCustomerAccount(account);
		return "redirect:/inventory/listAccounts";
	}
	// ------ action links within customer account table ------ >
	
	
	// ------------------- FinanceRecord methods ---------------------------------- >
	
	// listing all customer accounts
	@GetMapping("/listFinRecords")
	public String listFinanceRecords(Model model) {
		List<FinanceRecord> record = vehicleService.getFinanceRecords();
		model.addAttribute("FinanceRecord", record);
		
		return "all-finance-records";
	}
	
	// deletes customer account
	@GetMapping("/deleteFinanceRecord")
	public String deleteFinanceRecord(@RequestParam("financeId") int finId, Model model) {
		vehicleService.deleteCustomerAccount(finId);
		return "redirect:/inventory/listFinRecords";
	}
	
	
	// shows form for adding new customer 
	@GetMapping("/addFinanceRecord")
	public String showAddRecordForm(Model model) {
		CustomerAccount account = new CustomerAccount();
		model.addAttribute("CustomerAccount", account);
		return "finance-add-form";
	}
	
	// new customer data submission
	@PostMapping("/addFinanceRecordSave")
	public String addFinanceRecordSave(@Valid @ModelAttribute("FinanceRecord") FinanceRecord record, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "finance-add-form";
		}
		vehicleService.saveCustomerAccount(record);
		return "redirect:/inventory/listFinRecords";
	}
	
	// displays update form for customer account
	@GetMapping("/showFinanceUpdateForm")
	public String showFinanceFormForUpdate(@RequestParam("financeId") int finId, Model model) {
		FinanceRecord record = vehicleService.getFinanceRecord(finId);
		model.addAttribute("FinanceRecord", record);
		return "finance-update-form";
	}
	
	// form for updating customer account/data submission
	@PostMapping("/updateFinanceRecordSave")
	public String updateFinanceRecordSave(@Valid @ModelAttribute("FinanceRecord") FinanceRecord record, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "finance-update-form";
		}
		vehicleService.saveCustomerAccount(record);
		return "redirect:/inventory/listFinRecords";
	}

}


