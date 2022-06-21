package br.ifba.inf011.estrut.bridge.report;

public interface LoggerRelatorio {
	public void doHeader(String content);
	public void doTail();
	public void doLog(String content);
	public void open();
	public void close();
}
