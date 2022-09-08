package ru.otus.homework;

import ru.otus.homework.handler.ComplexProcessor;
import ru.otus.homework.listener.ListenerPrinterConsole;
import ru.otus.homework.listener.homework.HistoryListener;
import ru.otus.homework.model.Message;
import ru.otus.homework.model.ObjectForMessage;
import ru.otus.homework.processor.LoggerProcessor;
import ru.otus.homework.processor.ProcessorConcatFields;
import ru.otus.homework.processor.ProcessorUpperField10;
import ru.otus.homework.processor.homework.ProcessorExceptionThrower;
import ru.otus.homework.processor.homework.ProcessorSwapperFields;

import java.time.LocalDateTime;
import java.util.List;

public class HomeWork {

    /*
     Реализовать to do:
       1. Добавить поля field11 - field13 (для field13 используйте класс ObjectForMessage)
       2. Сделать процессор, который поменяет местами значения field11 и field12
       3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
             Секунда должна определяьться во время выполнения.
             Тест - важная часть задания
             Обязательно посмотрите пример к паттерну Мементо!
       4. Сделать Listener для ведения истории (подумайте, как сделать, чтобы сообщения не портились)
          Уже есть заготовка - класс HistoryListener, надо сделать его реализацию
          Для него уже есть тест, убедитесь, что тест проходит
     */

    public static void main(String[] args) {
        /*
           по аналогии с Demo.class
           из элеменов "to do" создать new ComplexProcessor и обработать сообщение
         */

        var processors = List.of(new ProcessorSwapperFields(),
                new ProcessorExceptionThrower(LocalDateTime::now));

        var complexProcessor = new ComplexProcessor(processors, ex -> {});
        var historyListener = new HistoryListener();
        complexProcessor.addListener(historyListener);

        var objForMsg = new ObjectForMessage();
        objForMsg.setData(List.of("10","20","muahaha"));
        var message = new Message.Builder(1L)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field11("field11")
                .field12("field12")
//                .field13(objForMsg)
                .build();

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(historyListener);
    }
}