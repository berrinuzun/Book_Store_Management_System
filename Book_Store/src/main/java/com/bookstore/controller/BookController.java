package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.entity.BookGenre;
import com.bookstore.entity.ShoppingChart;
import com.bookstore.service.BookService;
import com.bookstore.service.ShoppingChartService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ShoppingChartService sChartService;

	@GetMapping("/home")
	public String home() {
		return "homePage";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegisterPage";
	}
	
	@GetMapping("/books")
	public ModelAndView books() {
		
		List<Book> bookList = bookService.getAllBooks();
		
		return new ModelAndView("books", "book", bookList);
		
	}
	
	@PostMapping("/save")
	public String addNewBook(@ModelAttribute Book book) {
		
		try {
			bookService.save(book);
		} catch (Exception e) {
			return "redirect:/errorPage";
		}
		
		return "redirect:/books";
		
	}
	
	@GetMapping("errorPage")
	public String errorPage() {
		return "errorPage";
	}
	
	
	@ModelAttribute("genres")
    public BookGenre[] getGenres() {
        return BookGenre.values();
    }
	
	@GetMapping("/shopping_chart")
	public String getShoppingChart(Model model) {
		
		List<ShoppingChart> list = sChartService.getShoppingChart();
		model.addAttribute("book", list);
		
		return "shoppingChartPage";
	}
	
	@RequestMapping("/myShoppingChart/{ID}")
	public String getShoppingChart(@PathVariable("ID") int id) {
		
		Book book = bookService.getBookById(id);
		ShoppingChart shoppingChart = new ShoppingChart(book.getID(), book.getBookName(),
														book.getAuthorName(),book.getPrice(),
														book.getPage(),book.getBookGenre());
		sChartService.saveShoppingChart(shoppingChart);
		
		return "redirect:/shopping_chart";
		
	}
	
	@RequestMapping("/editBook/{ID}")
	public String editBook(@PathVariable("ID") int id, Model model) {
		
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		
	    return "bookEditPage";
		
	}
	
	@RequestMapping("/deleteBook/{ID}")
	public String deleteBook(@PathVariable("ID") int id) {
		
		bookService.deleteById(id);
		
		return "redirect:/books";
		
	}
	
}
