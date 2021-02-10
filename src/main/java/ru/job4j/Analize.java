package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, User> map = current.stream().collect(Collectors.toMap(User::getId, user -> user));
        int added = 0;
        int deleted = 0;
        int changed = 0;
        for (Integer key : map.keySet()) {
            int previousIndex = previous.indexOf(map.get(key));
            User previousUser = null;
            if (previousIndex >= 0) {
                previousUser = previous.get(previousIndex);
            }
            if (!previous.remove(map.get(key))) {
                added++;
            } else if (previousUser != null && !map.get(key).name.equals(previousUser.name)) {
                changed++;
            }
            deleted = previous.size();
        }
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}