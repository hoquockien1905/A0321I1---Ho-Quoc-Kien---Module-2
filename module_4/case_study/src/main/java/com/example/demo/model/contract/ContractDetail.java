package com.example.demo.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Integer contractDetailId;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false, referencedColumnName = "contract_id")
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attach_service_id", nullable = false, referencedColumnName = "attach_service_id")
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractDetailId, Integer quantity, Contract contract, AttachService attachService) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
