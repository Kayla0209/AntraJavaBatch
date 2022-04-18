final class Student {
    private final int id;
    private final String name;
    private final String address;

    public Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

    public static class Builder {
        private int id;
        private String name;
        private String address;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {}

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

class StudentReceiver {
    private volatile Student student;

    public StudentReceiver() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                student = Student.Builder.newInstance()
                        .setId(1)
                        .setName("K")
                        .setAddress("123 st")
                        .build();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                student = Student.Builder.newInstance()
                        .setId(2)
                        .setName("Shyam")
                        .setAddress("Delhi")
                        .build();
            }
        });

        t1.start();
        t2.start();
    }

    public Student getStudent()
    {
        return student;
    }
}

class BuilderDemo {
    public static void main(String args[])
    {
        StudentReceiver sr = new StudentReceiver();
        System.out.println(sr.getStudent());
    }
}