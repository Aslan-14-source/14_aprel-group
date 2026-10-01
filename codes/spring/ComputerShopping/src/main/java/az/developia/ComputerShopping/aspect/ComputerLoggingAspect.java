package az.developia.ComputerShopping.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ComputerLoggingAspect {

	private static final String POINTCUT = "execution(* az.developia.ComputerShopping.service..*(..))";

	@Before(POINTCUT)
	public void before() {

		System.out.println("========== @Before ==========");
		System.out.println("Service metodunun icrasından əvvəl");
	}

	@Around(POINTCUT)
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		String methodName = joinPoint.getSignature().getName();

		System.out.println("========== @Around BEFORE ==========");
		System.out.println("Metod: " + methodName);

		long start = System.currentTimeMillis();

		try {

			Object result = joinPoint.proceed();

			return result;

		} finally {

			long end = System.currentTimeMillis();

			System.out.println("========== @Around AFTER ==========");
			System.out.println("Metod: " + methodName);
			System.out.println("İcra müddəti: " + (end - start) + " ms");
		}
	}

	@AfterReturning(pointcut = POINTCUT, returning = "result")
	public void afterReturning(Object result) {

		System.out.println("========== @AfterReturning ==========");
		System.out.println("Nəticə uğurla qaytarıldı");
	}

	@AfterThrowing(pointcut = POINTCUT, throwing = "exception")
	public void afterThrowing(Exception exception) {

		System.out.println("========== @AfterThrowing ==========");
		System.out.println("Xəta: " + exception.getMessage());
	}

	@After(POINTCUT)
	public void after() {

		System.out.println("========== @After ==========");
		System.out.println("Service metodunun icrası tamamlandı");
	}
}	