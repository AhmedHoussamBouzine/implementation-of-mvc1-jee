/**
 * 
 */
package com.gl.dao;

import java.util.List;

import com.gl.beans.Option;


/**
 * @author houss
 *
 */
public interface OptionDao {
	 public Option addOption(Option option) throws Exception ;
	 public Option deleteOption(Option option) throws Exception;
	 public Option updateOption(Option option) throws Exception;
	 public Option getOption(String nom) throws Exception;
	 public List<Option> getOptions() throws Exception;
}
