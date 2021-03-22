package com.luxoft.springcore.travel;

import com.luxoft.springcore.objects.City;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravellingOpportunities implements ApplicationContextAware {
	
	private List<Connection> connections = new ArrayList<>();

	public List<Connection> getConnectionsList() {
		return Collections.unmodifiableList(connections);
	}

	public Connection getConnection(City source, City destination){
		for (Connection connection : connections) {
			if(connection.getSource().equals(source) && connection.getDestination().equals(destination)){
				return connection;
			}
		}
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		City moscow = context.getBean("moscow", City.class);
		City warsaw = context.getBean("warsaw", City.class);
		City sofia = context.getBean("sofia", City.class);
		City vienna = context.getBean("vienna", City.class);
		City krakow = context.getBean("krakow", City.class);

		connections.add(new Connection(moscow, warsaw, 1000));
		connections.add(new Connection(warsaw, krakow, 386));
		connections.add(new Connection(sofia, vienna, 1000));
		connections.add(new Connection(vienna, krakow, 166));
	}
}
