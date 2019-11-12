package com.pttl.service.order;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pttl.distributed.transaction.annotation.DistributedTransaction;
import com.pttl.distributed.transaction.context.DistributedTransactionContext;

@FeignClient(value = "product")
public interface ProductService {
    /*@RequestMapping(value = "/hi2",method = RequestMethod.GET)
    @DistributedTransaction(action = "myorder2")
    String sayHiFromClientOne(DistributedTransactionContext context,@RequestParam(value = "name") String name);*/

    @RequestMapping("/repertory")
    @DistributedTransaction(action="productPayment")
    public boolean payment(@RequestBody DistributedTransactionContext distributedTransactionContext,@RequestParam("productId") int productId, @RequestParam("repertory") int repertory);
}
