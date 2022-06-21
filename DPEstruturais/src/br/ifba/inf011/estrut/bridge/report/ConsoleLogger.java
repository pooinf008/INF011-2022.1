package br.ifba.inf011.estrut.bridge.report;

public class ConsoleLogger implements LoggerRelatorio{

	@Override
	public void doHeader(String content) {
		System.out.println(content);
	}

	@Override
	public void doTail() {
		
	}

	@Override
	public void doLog(String content) {
		System.out.println(content);
	}

	@Override
	public void open() {
		
	}

	@Override
	public void close() {
		
	}

}
