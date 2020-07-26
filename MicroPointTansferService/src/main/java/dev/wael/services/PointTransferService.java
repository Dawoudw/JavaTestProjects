package dev.wael.services;


public interface PointTransferService {

	public boolean transferpoint(Integer senderId , Integer recipientId , Integer amount);
}
