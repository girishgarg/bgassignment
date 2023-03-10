public class Account implements OnlineAccount,Comparable<Account>{

    Integer noOfRegularMovies;
    Integer noOfExclusiveMovies;
    String ownerName;

    Account(Integer noOfRegularMovies,Integer noOfExclusiveMovies,String ownerName){
        this.noOfExclusiveMovies=noOfExclusiveMovies;
        this.noOfRegularMovies=noOfRegularMovies;
        this.ownerName=ownerName;
    }

    public int monthlyCost(){
        return basePrice + (noOfRegularMovies*regularMoviePrice) +
                (noOfExclusiveMovies*exclusiveMoviePrice);
    }

    @Override
    public int compareTo(Account o) {
        return this.monthlyCost()-o.monthlyCost();
    }


    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }
}
