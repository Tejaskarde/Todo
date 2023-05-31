package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import  java.util.List;
import java.util.function.Predicate;


// code for business we add @service mark;
@Service
public class TodoService {
   private static   List<Todo> todos = new ArrayList<>(); // act like memory database
  private static int todoCount = 0;

  static {
          todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
     todos.add(new Todo(++todoCount,"Visit Grocery Store",false));
     todos.add(new Todo(++todoCount,"Learn AWS",false));
     todos.add(new Todo(++todoCount,"Swimming",false));
     todos.add(new Todo(++todoCount,"Yoga",false));
  }

  public List<Todo> findAll(){   // Business Logic
     return todos;
  }

  public Todo findById(int id){
/// Bruit force approch --------------//
          for (Todo todo : todos) {
              if (todo.getId() == id) {
                  return todo;
              }
          }
          return null;
          //-------------------//

//      //java logic to be written
//      Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//      Todo todo = todos.stream().filter(predicate).findFirst().get();
//      return todo;

  }

    public void addTodo(Todo todo){
      // is like adding element to arrayList
        todos.add(todo);
    }

     public void deleteTodo(int id){

             for (int i = 0; i < todos.size(); i++) {
                 Todo todo = todos.get(i);
                 if (todo.getId() == id) {
                     todos.remove(i);
                     break;

                     // another logic
                     /*
                     public void deleteTodo(ind id){
                     Predicates <? super Todo> predicate = todo -> todo.getId()==id;
                     todos.removeIf(predicate);
                     }
                     * */
                 }
             }
         }


         public  void  updateTodo(int id,Todo newtodo) {
             for (int i = 0; i < todos.size(); i++) {
                 Todo currentTodo = todos.get(i);
                 if (currentTodo.getId() == id) {
                     todos.set(i, newtodo);
                     break;
                 }
             }
         }
//// ether   i; find todo to be upate 2. udpade todo
                 //Todo todo = findById(id);   ///step1
                                          ///new field
              ///todo.setId(newTodo.getId());
               //todo.setTitle(newTodo.getTitle());
               //todo.setStatus(newTodo.getStatus());



         }
