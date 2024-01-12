public class Worm {
int numOfTimes=1;
String[] array ={
"public class Worm {",
"int numOfTimes",
"String[] array ={",
"};",
"public static void main(String[] args){",
"Worm worm = new Worm();",
"char quote = 34;",
"System.out.println(worm.array[0]);",
"System.out.println(worm.array[1]+'='+ (worm.numOfTimes+1)+';');",
"System.out.println(worm.array[2]);",
"for (int i = 0; i < worm.array.length; i++) {",
"System.out.println(quote+worm.array[i]+quote+',');",
"}",
"for (int i = 2; i <worm.array.length; i++) {",
" System.out.println(worm.array[i]);",
"}",
"}",
"}",

public static void main(String[] args){
Worm worm = new Worm();
char quote = 34;
System.out.println(worm.array[0]);
System.out.println(worm.array[1]+'='+ (worm.numOfTimes+1)+';');
System.out.println(worm.array[2]);
for (int i = 0; i < worm.array.length; i++) {
System.out.println(quote+worm.array[i]+quote+',');
}
for (int i = 2; i <worm.array.length; i++) {
 System.out.println(worm.array[i]);
}
}
}
