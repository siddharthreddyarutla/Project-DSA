# Java fundamentals

### Mutable

```java
import java.util.*;
class Main {
    public static void main(String[] args) {
        
        List<Integer> s = new ArrayList(Arrays.asList(10));
        System.out.println(s);
        add(s);
        System.out.println(s);
    }
    
    private static void add(List<Integer> a) {
        a.add(20);
    }
}
```
- Again, Java passes a copy of the reference to the List. 
- But unlike the first case, this time you’re mutating the object (List) that both s and a point to. 
- So when a.add(20) is called, the internal state of the same list is changed. 
- 📌 Key takeaway: When you mutate a mutable object (like List), the change is reflected outside the method.



### Transient

> The transient keyword is used to mark a field to be ignored during serialization.