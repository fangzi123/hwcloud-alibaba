package com.wdhw.api.util;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author fangjian
 */
@Slf4j
public class ExceptionUtil {

	public static void handleException(BlockException ex) {
		log.info("sentinel method=={}"
				,ex.getMessage());
	}

}