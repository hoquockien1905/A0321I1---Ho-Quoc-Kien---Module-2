package com.example.demo.controller;

import com.example.demo.exceptions.BorrowException;
import com.example.demo.model.Book;
import com.example.demo.model.Card;
import com.example.demo.service.IBookService;
import com.example.demo.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    ICardService cardService;

    @GetMapping("")
    public String getList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "book/book_list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/create")
    public String createBook(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "book/create";
        }
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewBorrowCard(@PathVariable("id") int id) {
        return new ModelAndView("book/view", "card", cardService.findById(id));
    }

    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) throws BorrowException {
        Card card = new Card();
        Book book = bookService.findById(id);
        if (book == null || book.getQuantity() == 0) {
            throw new BorrowException("Sách đã hết, vui lòng quay lại sau");
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            int borrowCardId = (int) (Math.random() * (99999 - 10000) + 10000);
            card.setId(borrowCardId);
            card.setBook(book);
            cardService.save(card);
        }
        redirectAttributes.addFlashAttribute("borrow", "Mượn thành công");
        return "redirect:/view/" + card.getId();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        bookService.delete(id);
        redirectAttributes.addFlashAttribute("delete", "Xóa sách thành công");
        return "redirect:/";
    }
}
