package model.exceptions;

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) {
		super(msg);// repassa a msg para o construtor da super classe. Permite que possa 
		//instanciar a exceção personalizada passando uma msg e essa msg fica armazenada
		//dentro da exceção
	}
	
}
