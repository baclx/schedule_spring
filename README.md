## Schedule in Spring - Là 1 cái bean hỗ trợ lặp lịch

Đầu tiên thì cta cần phải **@EnableScheduling** and **@Configuration** ở hàm main or trên class config schedule
```java
@Configuration
@EnableScheduling
@SpringBootApplication
public class ScheduleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}
}
```
Ở ví dụ này thì toi config ở hàm Main để spring có thể hiểu đc và khởi tạo cho cta

## Về lặp lịch thì có 2 loại
- 1 là kiểu interval

  > Chạy xuyên suốt trong quá trình chạy dự án

```java
@Scheduled(fixedDelay = 1000)
public void scheduleFixedDelayTask() {  
	System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);  
}
```

Output:
```
Fixed delay task - 1669017191
Fixed delay task - 1669017192
Fixed delay task - 1669017194
Fixed delay task - 1669017195
Fixed delay task - 1669017196
```

thêm tham số initialDelay

```java
// initialDelay - Hoãn 5s r mới gọi fixedDelay -> 15s  
@Scheduled(fixedDelay = 10000, initialDelay = 5000)  
public void scheduleFixedRateWithInitialDelayTask() {  
  
  long now = System.currentTimeMillis() / 1000;  
    System.out.println(  
  "Fixed rate (? delay) task with one second initial delay - " + now);  
}
```

Output:
```
before initial delay (5s) - 1669017487
Fixed rate (? delay) task with one second initial delay - 1669017492
Fixed rate (? delay) task with one second initial delay - 1669017502
Fixed rate (? delay) task with one second initial delay - 1669017512
```

- 2 là kiểu cron

  > Chạy từ mốc thời gian nào

```java
// cron  
// executed at 10:15 AM on the 15th day of every month.  
@Scheduled(cron = "0 15 10 15 * ?")  
public void scheduleTaskUsingCronExpression() {
	long now = System.currentTimeMillis() / 1000;  
    System.out.println("Schedule tasks using cron jobs - " + now);  
}
```