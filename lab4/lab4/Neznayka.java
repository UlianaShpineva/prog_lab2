package lab4;

public final class Neznayka extends Human {
    public Neznayka(String name) {
        super(name);
    }


    @Override
    public void memorise(String s, Integer i) throws OutOfMemoryError{
        class OutOfHumanMemoryError extends Error{
            public OutOfHumanMemoryError() {
                super();
            }

            public OutOfHumanMemoryError(String message) {
                super(message);
            }

            public OutOfHumanMemoryError(String message, Throwable cause) {
                super(message, cause);
            }

            public OutOfHumanMemoryError(Throwable cause) {
                super(cause);
            }

            protected OutOfHumanMemoryError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
                super(message, cause, enableSuppression, writableStackTrace);
            }
        }
        if (i > 1000) {
            throw new OutOfHumanMemoryError("Neznayka doesn't have enough memory");
        }
        super.memorise(s, i);
    }

}