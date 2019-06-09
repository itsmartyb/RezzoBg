package com.rezzobg.services;

import com.rezzobg.dto.ProposalDtoForList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ProposalService {

    public abstract List<ProposalDtoForList> getAllProposals();
}
