**Тема:** Автоматическое логирование<br>
**Цель:** Понять как реализуется AOP, какие для этого есть технические средства<br><br>
**Алгоритм/Требования:**<br>
<br>Разработать такой функционал:<br>
- метод класса можно пометить самодельной аннотацией @Log, например, так:
```
class TestLogging {
    @Log
    public void calculation(int param) {}
}
```
- при вызове этого метода "автомагически" в консоль должны логироваться значения параметров, например, так:
```
class Demo {
    public void action() {
        new TestLogging().calculation(6);
    }
}
```
в консоли дожно быть:
```
executed method: calculation, param: 6
```
- явного вызова логирования быть не должно!<br><br>
Учесть, что аннотацию можно поставить, например, на такие методы:
```
public void calculation(int param1)
public void calculation(int param1, int param2)
public void calculation(int param1, int param2, String param3)
```