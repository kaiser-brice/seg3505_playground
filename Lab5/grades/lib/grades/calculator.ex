defmodule Grades.Calculator do
  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    converted_homework = Enum.map(homework, &String.to_integer/1)
    sum_homework = Enum.sum(converted_homework)
    average_homework = (sum_homework/4)*0.15
    converted_labs = Enum.map(labs, &String.to_integer/1)
    sum_labs = Enum.sum(converted_labs)
    average_labs = (sum_labs/6)*0.30
    converted_midterm = :erlang.binary_to_integer(midterm)*0.25
    converted_final = :erlang.binary_to_integer(final)*0.30
    mark = average_homework+average_labs+converted_midterm+converted_final
  end

  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    converted_homework = Enum.map(homework, &String.to_integer/1)
    sum_homework = Enum.sum(converted_homework)
    average_homework = (sum_homework/4)*0.15
    converted_labs = Enum.map(labs, &String.to_integer/1)
    sum_labs = Enum.sum(converted_labs)
    average_labs = (sum_labs/6)*0.30
    converted_midterm = :erlang.binary_to_integer(midterm)*0.25
    converted_final = :erlang.binary_to_integer(final)*0.30
    average_mark = average_homework+average_labs+converted_midterm+converted_final
    cond do
      average_mark >= 90 -> "A+"
      average_mark >= 85 -> "A"
      average_mark >= 80 -> "A-"
      average_mark >= 75 -> "B+"
      average_mark >= 70 -> "B"
      average_mark >= 65 -> "C+"
      average_mark >= 60 -> "C"
      average_mark >= 55 -> "D+"
      average_mark >= 50 -> "D"
      true -> "F"
    end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    converted_homework = Enum.map(homework, &String.to_integer/1)
    sum_homework = Enum.sum(converted_homework)
    average_homework = (sum_homework/4)*0.15
    converted_labs = Enum.map(labs, &String.to_integer/1)
    sum_labs = Enum.sum(converted_labs)
    average_labs = (sum_labs/6)*0.30
    converted_midterm = :erlang.binary_to_integer(midterm)*0.25
    converted_final = :erlang.binary_to_integer(final)*0.30
    average_mark = average_homework+average_labs+converted_midterm+converted_final
    cond do
      average_mark == 100 -> "10"
      average_mark >= 90 -> "9"
      average_mark >= 80 -> "8"
      average_mark >= 70 -> "7"
      average_mark >= 60 -> "6"
      average_mark >= 50 -> "5"
      average_mark >= 40 -> "4"
      average_mark >= 30 -> "3"
      average_mark >= 20 -> "2"
      average_mark >= 10 -> "1"
      average_mark >= 0 -> "0"
    end
  end
end
