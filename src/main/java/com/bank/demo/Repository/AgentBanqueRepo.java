package com.bank.demo.Repository;

import com.bank.demo.Model.AgentBanque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentBanqueRepo extends JpaRepository<AgentBanque,Long> {
}
