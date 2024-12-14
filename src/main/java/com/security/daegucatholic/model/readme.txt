Lombok 어노테이션 설명
	•	@Data: Lombok의 어노테이션으로 getter, setter, toString, equals, hashCode 메서드를 자동으로 생성합니다.
	•	추가적으로 필요한 경우 @Builder, @NoArgsConstructor, @AllArgsConstructor 등을 사용할 수도 있습니다.

주의 사항
	•	createdAt, updatedAt 등의 필드는 Java의 LocalDateTime 클래스를 사용하여 날짜와 시간을 매핑합니다.
	•	Lombok을 사용하지 않는다면 직접 getter, setter, toString 등을 구현해야 합니다.
