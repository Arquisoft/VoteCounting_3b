package es.uniovi.asw.controller;

public class SearchOptions {
	private String option;
	private String optionName;

	public SearchOptions() {

	}

	public SearchOptions(String option, String optionName) {
		this.option = option;
		this.optionName = optionName;
	}

	public String getOption() {
		return option;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

}
