package ua.com.osipenko.daycosts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	TextView tvDate, tvItemName, tvItemPrice, summa;
	EditText etItemName, etItemPrice;
	Button addButton, resetButton;
	double aSumma = 0.0;
	String stringItemName = "", stringItemPrice = "";
	int count = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		tvItemName = (TextView) findViewById(R.id.itemName);
		tvItemPrice = (TextView) findViewById(R.id.itemPrice);
		summa = (TextView) findViewById(R.id.summa);
		
		etItemName = (EditText)findViewById(R.id.etItemName);
		etItemPrice = (EditText)findViewById(R.id.etItemPrice);
		
		addButton = (Button) findViewById(R.id.addButton);
		addButton.setOnClickListener(this);
		
		resetButton = (Button) findViewById(R.id.resetButton);
		resetButton.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		switch (v.getId())
		{
		case R.id.addButton:
			String itemName = etItemName.getText().toString();
			String itemPrice = etItemPrice.getText().toString();
			
			//Проверка полей на "не пустое?" 
			if(itemName.matches(""))
			{
				Toast toast = Toast.makeText(this, "Введите значение в поле \"Название\"", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
			if(itemPrice.matches(""))
			{
				Toast toast = Toast.makeText(this, "Введите значение в поле \"Стоимость\"", Toast.LENGTH_SHORT);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
			}
			
			//В поле mainContent вносим название + цена цену пишем в промежуточную переменную aSumma
			aSumma += Double.parseDouble(etItemPrice.getText().toString());
			summa.setText(Double.toString(aSumma));
			count += 1;
			stringItemName += count +".\t " + itemName + ":\n"; 
			stringItemPrice += itemPrice + " грн\n";	
			tvItemName.setText(stringItemName);
			tvItemPrice.setText(stringItemPrice);
			
			//Очищаем поля ввода
			etItemName.setText("");
			etItemPrice.setText("");
			break;
		case R.id.resetButton:
			// Вывести предупреждение про удаление и обунлить сумму и список.
			tvItemName.setText("");
			tvItemPrice.setText("");
			summa.setText("0");
			break;
		}
		etItemName.requestFocus();
	}
}
