package dev.university.springbooks.controller;

import dev.university.springbooks.model.Book;
import dev.university.springbooks.service.BookService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@NoArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("books_list")
    public String viewBooksList(Model model) {
        List<Book> lb = bookService.findAll();
        model.addAttribute("lb", lb);
        return "books_list";
    }

    @RequestMapping("/new_book")
    public String showFormNewBook(Model model) {
        Book nb = new Book();
        model.addAttribute("book", nb);
        return "new_book";
    }
    @PostMapping(value="/save_book")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books_list";
    }
    @RequestMapping("/edit_book/{idb}")
    public ModelAndView showEditFormBook(@PathVariable(name = "idb") Long idb) {
        ModelAndView mav = new ModelAndView("edit_book");
        Optional<Book> eb = bookService.findById(idb);
        mav.addObject("book", eb);
        return mav;
    }
    @RequestMapping("/delete_book/{idb}")
    public String deleteBook(@PathVariable(name = "idb") Long idb) {
        bookService.deleteById(idb);
        return "redirect:/books_list";
    }
}
