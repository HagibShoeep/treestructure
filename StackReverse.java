/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

/**
 *
 * @author شعيب
 */
public class StackReverse<E  > 
{
   public static <E> void reverse(E[ ] a) {  ArrayStack<E> buffer = new ArrayStack<>(a.length);
for (int i=0; i < a.length; i++)
 buffer.push(a[i]);
for (int i=0; i < a.length; i++)
a[i] = buffer.pop();
 }
}
