package de.stiffi.media.carboncoder.api;

public class JobListCriteria {

	public enum Operator {
		EQUAL("EQUAL"), LIKE("LIKE"), LESSTHAN("LESSTHAN"), GREATERTHAN("GREATERTHAN");

		private Operator( String name ) {
			this.name = name;
		}

		private final String name;

		@Override
		public String toString() {
			return name;
		}

	}

	private String parameter;

	private String value;

	private Operator operator;

	public JobListCriteria( String parameter, Operator operator, String value ) {
		this.parameter = parameter;
		this.operator = operator;
		this.value = value;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter( String parameter ) {
		this.parameter = parameter;
	}

	public String getValue() {
		return value;
	}

	public void setValue( String value ) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator( Operator operator ) {
		this.operator = operator;
	}

}
