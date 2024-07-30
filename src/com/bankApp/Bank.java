package com.bankApp;

class Bank {
        private User[] users;
        private int maxAttempts = 5;

        public Bank(User[] users) {
            this.users = users;
        }

        public User authenticate(String userId, String password) {
            for (User user : users) {
                if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                    return user;
                }
            }
            return null;
        }

        public boolean isBlocked(int attempts) {
            return attempts >= maxAttempts;
        }
}
