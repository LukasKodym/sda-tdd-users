package pl.sda;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDB {

    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public int getUsersCount() {
        return users.size();
    }

    public Map<Position, Integer> countPositions() {
        Map<Position, Integer> result = new HashMap<>();
        for (User user : users) {
            Position position = user.getPossition();
            if (result.get(position) == null) { // you can replace with puIfAbsent method
                result.put(position, 0);
            }
            Integer count = result.get(position);
            result.put(position, ++count);
        }
        return result;

    }

    public Double countAverageAge() {
        Double age = users.stream().mapToDouble(User::getAge).sum();
        return age / users.size();
    }

    public Map<String, Integer> countNames() {
        final Map<String, Integer> namesCount = new HashMap<>();
        users.forEach(p -> {
            namesCount.putIfAbsent(p.getName(), 0);
            namesCount.compute(p.getName(), (s, c) -> ++c);
        });
        return namesCount;
    }
}
