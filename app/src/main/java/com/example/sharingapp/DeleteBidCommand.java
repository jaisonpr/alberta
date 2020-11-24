package com.example.sharingapp;

import android.content.Context;

import java.util.concurrent.ExecutionException;

/**
 * Command to delete a bid
 */
public class DeleteBidCommand extends Command {

    private BidList bid_list;
    private Bid bid;
    private Context context;

    public DeleteBidCommand(BidList bid_list, Bid bid, Context context) {
        this.bid_list = bid_list;
        this.bid = bid;
        this.context = context;
    }

  /*  // Delete bid locally
    public void execute(){
        bid_list.removeBid(bid);
        super.setIsExecuted(bid_list.saveBids(context));
    }*/

    // Delete the item remotely from server
    public void execute() {
        ElasticSearchManager.RemoveBidTask remove_bid_task = new ElasticSearchManager.RemoveBidTask();
        remove_bid_task.execute(bid);

        try {
            if(remove_bid_task.get()) {
                super.setIsExecuted(true);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            super.setIsExecuted(false);
        }
    }
}