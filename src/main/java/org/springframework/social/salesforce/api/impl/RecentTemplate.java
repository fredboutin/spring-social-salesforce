package org.springframework.social.salesforce.api.impl;

import java.util.List;

import org.springframework.social.salesforce.api.RecentOperations;
import org.springframework.social.salesforce.api.ResultItem;
import org.springframework.social.salesforce.api.Salesforce;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Default implementation of RecentOperations.
 *
 * @author Umut Utkan
 */
public class RecentTemplate extends AbstractSalesForceOperations<Salesforce> implements RecentOperations
{

    private RestTemplate restTemplate;

    public RecentTemplate(Salesforce api,
                          RestTemplate restTemplate)
    {
        super(api);
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ResultItem> recent()
    {
        return api.readList(restTemplate.getForObject(api.getBaseUrl() + "/v23.0/recent", JsonNode.class),
                            ResultItem.class);
    }

}
